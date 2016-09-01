package chapter10;

import java.util.Optional;

/**
 * Created by fall1999y on 2016. 7. 27..
 */
public class OptionalMain {
    public static void main(String[] args) {
        Optional<Car> optCar = Optional.empty();
        Car car = new Car();
        Optional<Car> notnullOptCal = Optional.of(car);
        car = null;
        Optional<Car> ofNullableCar = Optional.ofNullable(car);

        Insurance insurance = null;
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
//        optInsurance.get().getName();
        Optional<String> name = optInsurance.map(Insurance::getName);
        System.out.println(name);

        Person person = new Person();

//        System.out.println(optCar.get().getInsurance().get().getName());
//        System.out.println(new OptionalMain().getCarInsuranceName(person));

//        System.out.println(new OptionalMain().getCarInsuranceName(person).isPresent());

        Optional<Person> optPerson = Optional.of(person);
//        Optional<String> name = optPerson.map(Person::getCar).map(Car::getInsurance).map(Insurance::getName);
        Optional<String> optName = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
        System.out.println(optName.orElse("Unknown"));
    }

    public Optional<String> getCarInsuranceName(Person person) {
        return person.getCar().map(Car::getInsurance).map(i->i.get().getName());
    }
}

