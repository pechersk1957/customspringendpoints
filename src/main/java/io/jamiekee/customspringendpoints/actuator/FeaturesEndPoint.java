package io.jamiekee.customspringendpoints.actuator;

import com.google.gson.Gson;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Endpoint(id="features")
public class FeaturesEndPoint {

    @WriteOperation
    public String configureFeature(String payload) {
        Gson gson = new Gson();
        Feature[] features = gson.fromJson(payload,Feature[].class);
        StringBuilder strBuilder = new StringBuilder();
        Arrays.stream(features).forEach(i -> strBuilder.append(i.getName() + " "));
        return String.format("Size %d. Names: %s", features.length,strBuilder.toString());
    }

    public static class Feature {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
