$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("UI_SpaceX.feature");
formatter.feature({
  "line": 1,
  "name": "Test Assignment UI and API",
  "description": "",
  "id": "test-assignment-ui-and-api",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Verify that the SpaceX mission has launched correct Satellite of proper version",
  "description": "",
  "id": "test-assignment-ui-and-api;verify-that-the-spacex-mission-has-launched-correct-satellite-of-proper-version",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "User fetches spaceX details using API",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "the satellte name and version should be Starlink-11 (v1.0)",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 11,
  "name": "Verify that the SpaceX mission has landed successfully on expected landing destination",
  "description": "",
  "id": "test-assignment-ui-and-api;verify-that-the-spacex-mission-has-landed-successfully-on-expected-landing-destination",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "User fetches spaceX details using API",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "the satellite has successfully landed on ASDS",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 16,
  "name": "Verify that the SpaceX mission has had no failures yet",
  "description": "",
  "id": "test-assignment-ui-and-api;verify-that-the-spacex-mission-has-had-no-failures-yet",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User fetches spaceX details using API",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "the satellite has successfully landed with no failures",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});