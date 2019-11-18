#!/bin/bash

# Wait for MySQL database to be running
sleep 5

# Start SonarQube
./bin/run.sh &

curlAdmin() {
    curl -u admin:admin $@
}

URL_API=http://192.168.99.100/:9000/api

isUp() {
    curl -s -u admin:admin -f "$URL_API/system/info"
}

# Wait for server to be up
while [ -z "$(isUp)" ] ; do sleep 5 ; done

# Provision an admin user
if [ "$USER_LOGIN" ] && [ "$USER_NAME" ] && [ "$USER_PASSWORD" ]
then
    curlAdmin "$URL_API/users/create" \
                    --data-urlencode "login=$USER_LOGIN" \
                    --data-urlencode "name=$USER_NAME" \
                    --data-urlencode "password=$USER_PASSWORD"
    #RIGHTS=( "admin" "profileadmin" ) # Other rights: gateadmin, scan, provisioning
    #for right in "${RIGHTS[@]}" ; do
    #    curlAdmin "$URL_API/permissions/add_user" \
    #                --data-urlencode "login=$USER_LOGIN" \
    #                --data-urlencode "permission=$right"
    #done

    # Above rights are only for general administration of SonarQube. We need
    # to be a member of the sonar-administrators group to be able to manage
    # projects permissions.
    curlAdmin "$URL_API/user_groups/add_user" \
                        --data-urlencode "name=sonar-administrators" \
                        --data-urlencode "login=$USER_LOGIN"
    curl -u $USER_LOGIN:$USER_PASSWORD "$URL_API/users/deactivate" \
                    --data-urlencode "login=admin"
fi

wait