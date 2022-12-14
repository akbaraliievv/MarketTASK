package clasess;

import enums.Banks;
import enums.Country;

import java.time.LocalDate;

public class Person {
    private String fullName;
    private int age;
    private Country country;
    private Banks banks;
    private long bankAccount;


    public Person(String fullName, int age,  Country country,Banks banks,Long bankAccount) {
        this.fullName = fullName;
        this.age = age;
        this.country = country;
        this.bankAccount = bankAccount;
        this.banks = banks;
    }

    public Banks getBanks() {
        return banks;
    }

    public void setBanks(Banks banks) {
        this.banks = banks;
    }

    public long getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", country=" + country +
                ",banks =" +banks+
                ", bank=" + bankAccount +
                '}';
    }
}
