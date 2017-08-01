package study.jdk8.optional;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by alvin on 17-8-1.
 */
public class OptionalDemo {

    private void init() {

        // final class

        Optional<String> nonNull = Optional.of("optional");

        Optional<String> isNull = Optional.ofNullable(null);

        Optional<String> isNullEmpty = Optional.empty();

    }

    public static void use() {

        /** init */
        Optional<String> nonNull = Optional.of("use optional");
        Optional<String> isNull = Optional.ofNullable(null);



        /** isPresent() :  Optional != null  ? true : false  */
        nonNull.isPresent(); // true
        isNull.isPresent(); // false



        /** get() :  Optional != null  ? Optional value  : java.util.NoSuchElementException: No value present  */
        nonNull.get(); // use optional
        //isNull.get(); java.util.NoSuchElementException: No value present




        /** orElse(default value) */
        nonNull.orElse("hello world"); // use optional
        isNull.orElse("hello world"); // hello world



        /** orElseGet(default value coding block) */
        nonNull.orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "hello world";
            }
        }); // use optional

        isNull.orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "hello world";
            }
        }); // hello world

        nonNull.orElseGet(() -> "hello world"); // use optional
        isNull.orElseGet(() -> "hello world"); // hello world



        /** orElseThrow(default Exception coding block) */
        nonNull.orElseThrow(new Supplier<RuntimeException>() {
            @Override
            public RuntimeException get() {
                return new RuntimeException();
            }
        }); // use optional

//        isNull.orElseThrow(new Supplier<RuntimeException>() {
//            @Override
//            public RuntimeException get() {
//                return new RuntimeException();
//            }
//        }); // java.lang.RuntimeException

        nonNull.orElseThrow(() -> new RuntimeException()); // use optional
//        isNull.orElseThrow(() -> new RuntimeException()); // java.lang.RuntimeException




        /** filter(filter coding block) */
        nonNull.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.length() > 1)
                    return true;
                else
                    return false;
            }
        }); // Optional Object

       isNull.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.length() > 1)
                    return true;
                else
                    return false;
            }
        }); // Optional.empty

        nonNull.filter(s->s.length()>1); // Optional Object
        isNull.filter(s->s.length()>1); // Optional.empty



        /**
         * map
         * ifPresent
         * flatMap
         * */

    }


    public static void main(String[] args) {

        use();

    }
}
