[![CircleCI](https://circleci.com/gh/pablozoani/java-backend-demo.svg?style=svg)](https://circleci.com/gh/pablozoani/java-backend-demo)

# Java Backend Demo Project

## Project description

### Simple Web Application
That models an academy manager from the database, following next stack:

- Database:
  - MySQL (production)
  - H2 (development)
- Object Relational Mapping:
  - Hibernate
- Repository, Service and Controller layers
  - Spring Boot
- Front-End:
  - HTML5
  - Bootstrap
  - Thymeleaf

DDL & DML for the database schema can be found in:
```
./src/main/resources/-schema.sql
```
```
./src/main/resources/data.sql
```

### Some Object Oriented Programming Examples
I will be adding some design patterns and OOP demos in the path:
```
./src/main/java/z_other_oop
```

## Run in terminal from the root folder
```
git clone https://github.com/pablozoani/java-backend-demo.git
```

```
cd java-backend-demo
```

### Test cases
```
mvn test -e
```

### Web Application
```
mvn spring-boot:run
```
And go to:
```
localhost:8080
```

## Entity relationship diagram

![alt text](java-backend-demo-diagram.png "ERD")

## Project file tree on latest commit

```
java-backend-demo
 ├── .gitignore
 ├── README.md
 ├── java-backend-demo-diagram.png
 ├── java-backend-demo.iml
 ├── pom.xml
 └─> src
     ├─> main
     │   ├─> java
     │   │   └─> com
     │   │       └─> pablozoani
     │   │           ├─> utils
     │   │           │   └── ConsoleColors.java
     │   │           ├─> webapp
     │   │           │   ├── Main.java
     │   │           │   ├─> init
     │   │           │   │   └── StartUp.java
     │   │           │   └─> layers
     │   │           │       ├─> business
     │   │           │       │   ├─> controller
     │   │           │       │   │   ├── AcademyController.java
     │   │           │       │   │   ├── CourseController.java
     │   │           │       │   │   ├── ExceptionHandlerController.java
     │   │           │       │   │   ├── IndexController.java
     │   │           │       │   │   ├── InstructorController.java
     │   │           │       │   │   └── StudentController.java
     │   │           │       │   ├─> datatransferobject
     │   │           │       │   │   ├── AcademyDTO.java
     │   │           │       │   │   ├── CourseDTO.java
     │   │           │       │   │   ├── InstructorDTO.java
     │   │           │       │   │   └── StudentDTO.java
     │   │           │       │   ├─> exception
     │   │           │       │   │   └── NotFoundException.java
     │   │           │       │   ├─> repository
     │   │           │       │   │   ├── AcademyDAO.java
     │   │           │       │   │   ├── CourseDAO.java
     │   │           │       │   │   ├─> CustomImpl
     │   │           │       │   │   │   ├── AcademyDAO.java
     │   │           │       │   │   │   ├── AcademyDAOImpl.java
     │   │           │       │   │   │   ├── CourseDAO.java
     │   │           │       │   │   │   ├── CourseDAOImpl.java
     │   │           │       │   │   │   ├── InstructorDAO.java
     │   │           │       │   │   │   ├── InstructorDAOImpl.java
     │   │           │       │   │   │   ├── StudentDAO.java
     │   │           │       │   │   │   ├── StudentDAOImpl.java
     │   │           │       │   │   │   └─> base
     │   │           │       │   │   │       ├── BaseDAO.java
     │   │           │       │   │   │       ├── BasePersonDAO.java
     │   │           │       │   │   │       └── PersonDAO.java
     │   │           │       │   │   ├── InstructorDAO.java
     │   │           │       │   │   ├── StudentDAO.java
     │   │           │       │   │   └─> base
     │   │           │       │   │       └── PersonDAO.java
     │   │           │       │   └─> service
     │   │           │       │       ├── AcademyService.java
     │   │           │       │       ├── AcademyServiceImpl.java
     │   │           │       │       ├── CourseService.java
     │   │           │       │       ├── CourseServiceImpl.java
     │   │           │       │       ├── InstructorService.java
     │   │           │       │       ├── InstructorServiceImpl.java
     │   │           │       │       ├── StudentService.java
     │   │           │       │       ├── StudentServiceImpl.java
     │   │           │       │       └─> base
     │   │           │       │           └── PersonService.java
     │   │           │       └─> model
     │   │           │           ├── Academy.java
     │   │           │           ├── Course.java
     │   │           │           ├── Instructor.java
     │   │           │           ├── Student.java
     │   │           │           └─> base
     │   │           │               ├── BaseEntity.java
     │   │           │               ├── FieldOfStudy.java
     │   │           │               └── Person.java
     │   │           └─> z_other_oop
     │   │               ├── Singleton.java
     │   │               ├─> a_decorator
     │   │               │   ├── Main.java
     │   │               │   ├── Phasor.java
     │   │               │   ├── SignalGenerator.java
     │   │               │   ├── SineWaveGenerator.java
     │   │               │   └── TriangularWaveGenerator.java
     │   │               ├─> b_builder
     │   │               │   ├── AddressBuilder.java
     │   │               │   ├── AddressBuilderImpl.java
     │   │               │   ├── AddressBuilders.java
     │   │               │   └── Main.java
     │   │               ├─> c_strategy
     │   │               │   ├── AlphabeticalSort.java
     │   │               │   ├── BabyNameList.java
     │   │               │   ├── LengthBasedSort.java
     │   │               │   ├── Main.java
     │   │               │   ├── StringArraySortAlgorithm.java
     │   │               │   └── StringArraySortAlgorithms.java
     │   │               ├─> d_observer
     │   │               │   ├── Main.java
     │   │               │   ├── Message.java
     │   │               │   ├── Receiver.java
     │   │               │   ├── Sender.java
     │   │               │   └── User.java
     │   │               ├─> reusable_entities
     │   │               │   ├── Address.java
     │   │               │   ├── BankAccount.java
     │   │               │   ├── Customer.java
     │   │               │   ├── Person.java
     │   │               │   └── Product.java
     │   │               └─> z_trash
     │   │                   ├─> designpattern
     │   │                   │   ├─> builder
     │   │                   │   │   ├── CarBuilder.java
     │   │                   │   │   ├── Director.java
     │   │                   │   │   ├── Main.java
     │   │                   │   │   ├── MotorCycleBuilder.java
     │   │                   │   │   ├── Product.java
     │   │                   │   │   └── VehicleBuilder.java
     │   │                   │   ├─> decorator2
     │   │                   │   │   ├── IceCream.java
     │   │                   │   │   ├── IceCreamDecorator.java
     │   │                   │   │   ├── IceCreamImpl.java
     │   │                   │   │   ├── IceCreamPrefixer.java
     │   │                   │   │   ├── IceCreamSuffixer.java
     │   │                   │   │   └── Main.java
     │   │                   │   ├─> decorator3
     │   │                   │   │   ├── ConcreteHouse.java
     │   │                   │   │   ├── FloorDecorator.java
     │   │                   │   │   ├── House.java
     │   │                   │   │   ├── HouseDecorator.java
     │   │                   │   │   ├── Main.java
     │   │                   │   │   └── PaintDecorator.java
     │   │                   │   ├─> decorator4
     │   │                   │   │   ├── Main.java
     │   │                   │   │   ├── OpenPTrackData.java
     │   │                   │   │   ├── OpenPTrackDataDecorator.java
     │   │                   │   │   ├── OpenPTrackDataImpl.java
     │   │                   │   │   ├── OpenPTrackDataOffset.java
     │   │                   │   │   └── OpenPTrackDataScale.java
     │   │                   │   ├─> observer
     │   │                   │   │   ├── Blog.java
     │   │                   │   │   ├── Main.java
     │   │                   │   │   ├── Observer.java
     │   │                   │   │   ├── Subject.java
     │   │                   │   │   └── User.java
     │   │                   │   ├─> prototype
     │   │                   │   │   ├── BasicCar.java
     │   │                   │   │   ├── Ford.java
     │   │                   │   │   ├── Main.java
     │   │                   │   │   └── Nano.java
     │   │                   │   ├─> proxy
     │   │                   │   │   ├── ConcreteSubject.java
     │   │                   │   │   ├── Main.java
     │   │                   │   │   ├── Subject.java
     │   │                   │   │   └── SubjectProxy.java
     │   │                   │   └─> singleton
     │   │                   │       └── Captain.java
     │   │                   └─> models
     │   │                       ├─> artist
     │   │                       │   ├── Artist.java
     │   │                       │   ├── Book.java
     │   │                       │   ├── Composer.java
     │   │                       │   ├── LiteraryGenre.java
     │   │                       │   ├── MusicPiece.java
     │   │                       │   ├── Painter.java
     │   │                       │   ├── Performable.java
     │   │                       │   ├── Performer.java
     │   │                       │   ├── Picture.java
     │   │                       │   ├── Producer.java
     │   │                       │   ├── Program.java
     │   │                       │   ├── Sculptor.java
     │   │                       │   ├── Sculpture.java
     │   │                       │   ├── Work.java
     │   │                       │   ├── Writer.java
     │   │                       │   ├── diagram.png
     │   │                       │   └── diagram.puml
     │   │                       ├─> house
     │   │                       │   ├── Dimensions.java
     │   │                       │   ├── Factory.java
     │   │                       │   ├── Floor.java
     │   │                       │   ├── FloorImpl.java
     │   │                       │   ├── House.java
     │   │                       │   ├── Main.java
     │   │                       │   ├── diagram.png
     │   │                       │   ├── diagram.puml
     │   │                       │   └─> rooms
     │   │                       │       ├── BathRoom.java
     │   │                       │       ├── BedRoom.java
     │   │                       │       ├── DiningRoom.java
     │   │                       │       ├── Kitchen.java
     │   │                       │       ├── LivingRoom.java
     │   │                       │       ├── Room.java
     │   │                       │       └── RoomType.java
     │   │                       └─> store
     │   │                           ├── Aisle.java
     │   │                           ├── Main.java
     │   │                           ├── Product.java
     │   │                           ├── ProductImpl.java
     │   │                           ├── Shelf.java
     │   │                           ├── Store.java
     │   │                           ├── diagram.png
     │   │                           └── diagram.puml
     │   └─> resources
     │       ├── -schema.sql
     │       ├── application.yml
     │       ├── data.sql
     │       └─> templates
     │           ├─> academy
     │           │   └── academy.html
     │           ├─> course
     │           │   └── course.html
     │           ├── error.html
     │           ├── index.html
     │           ├─> instructor
     │           │   └── instructor.html
     │           └─> student
     │               └── student.html
     └─> test
         ├─> java
         │   ├── ObjectTest.java
         │   └─> com
         │       └─> pablozoani
         │           └─> webapp
         │               └─> layers
         │                   └─> business
         │                       ├─> datatransferobject
         │                       │   └── DTOTests.java
         │                       ├─> repository
         │                       │   └── RepositoryTests.java
         │                       └─> service
         │                           ├── AcademyServiceImplTest.java
         │                           ├── CourseServiceImplTest.java
         │                           ├── InstructorServiceImplTest.java
         │                           └── StudentServiceImplTest.java
         └─> resources
             └── application.yml
```
