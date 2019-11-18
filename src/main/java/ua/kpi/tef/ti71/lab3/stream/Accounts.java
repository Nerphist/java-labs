package ua.kpi.tef.ti71.lab3.stream;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public interface Accounts {
    static final Random RANDOM = new Random();
    static Account getAccount(){
        Fairy fairy = Fairy.create();
        Person person = fairy.person();


        Account fakeAccount = new Account();
        fakeAccount.setFirstName(person.getFirstName());
        fakeAccount.setLastName(person.getLastName());
        fakeAccount.setEmail(person.getEmail());
        fakeAccount.setBirthday(LocalDate.of(
                person.getDateOfBirth().getYear(),
                person.getDateOfBirth().getMonthValue(),
                person.getDateOfBirth().getDayOfMonth()));
        fakeAccount.setSex(Sex.valueOf(person.getSex().name()));
        fakeAccount.setBalance(BigDecimal.valueOf(RANDOM.nextInt(200_000)));
        fakeAccount.setCreationDate(LocalDate.now());

        return fakeAccount;
    }

    static List<Account> getAccountList(int size){
        return range(0, size)
                .mapToObj(i -> getAccount())
                .collect(toList());
    }
}

