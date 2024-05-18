package StepDefination;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {

		Step step = new Step();

		if (Step.place_id == null) {
			step.add_place_payload("Ripon", "Dubai");
			step.user_call_with_request("AddPlaceAPI", "Post");
			step.verify_place_id_created_map_to_using("Ripon", "GetPlaceAPI");
		}

	}

}
