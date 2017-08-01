package study.jdk8.optional;

import java.util.Optional;

/**
 * Created by alvin on 17-8-1.
 */
public class OptionalDemo {

    public void a(){

        Optional<String> notnull = Optional.of("String");

        Optional<String> isnull = Optional.ofNullable(null);

        Optional<String> isnull2 = Optional.empty();

    }
}
