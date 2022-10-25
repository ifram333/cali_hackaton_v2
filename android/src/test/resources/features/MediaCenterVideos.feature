@Android @MediaCenter
Feature: Videos
  The purpose of this feature is to cover all the possible scenarios related to the videos in Media Center.
  Estimated execution time:

  @Test
  Scenario Outline: 01. Scenario description with "<region>", "<location>", "<profile>", "<category>", and "<videoName>"
    Given I am a user located in "<region>" - "<location>" with profile "<profile>"
    When I open the video category "<category>" and open the video "<videoName>"

    Examples:
      | region   | location      | profile   | category    | videoName                              |
      | Americas | United States | Architect | ACCESSORIES | Jet Bond Spray Adhesive Training Video |