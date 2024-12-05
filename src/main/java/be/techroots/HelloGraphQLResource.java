package be.techroots;

import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class HelloGraphQLResource {

    @Query
    public List<CustomerProduct> getProducts() {

        return List.of(new InternetLine("Test", 1000), new MobileLine("Test", "0470000000"));
    }
}

sealed interface CustomerProduct permits InternetLine, MobileLine {
    String name();
}

record InternetLine(String name, int speed) implements CustomerProduct {

}

record MobileLine(String name, String mobileNumber) implements CustomerProduct {

}