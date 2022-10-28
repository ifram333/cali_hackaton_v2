@Android @MediaCenter
Feature: Videos
  The purpose of this feature is to cover all the possible scenarios related to the videos in Media Center.

  Scenario Outline: 01. Open the video "<videoName>" under the category "<category>" with a profile "<profile>" in "<region>" - "<location>"
    Given I am a user located in "<region>" - "<location>" with profile "<profile>"
    When I open the video "<videoName>" that is located in the category "<category>"
    Then The video starts playing

    Examples:
      | region   | location      | profile   | category                | videoName                                        |
      | Americas | United States | Architect | ACCESSORIES             | Jet Bond Spray Adhesive Training Video           |
      | Americas | United States | Architect | FIRESTONE METAL ROOFING | Firestone Building Products Metal Sheet and Coil |

  Scenario Outline: 02. Fast forward the video "<videoName>"
    Given I am a user located in "<region>" - "<location>" with profile "<profile>"
    And I open the video "<videoName>" that is located in the category "<category>"
    When The video starts playing
    And I fast forward the video
    Then The video keeps playing

    Examples:
      | region   | location      | profile   | category    | videoName                              |
      | Americas | United States | Architect | ACCESSORIES | Jet Bond Spray Adhesive Training Video |

  Scenario Outline: 03. Rewind the video "<videoName>" to the beginning after it has finished
    Given I am a user located in "<region>" - "<location>" with profile "<profile>"
    And I open the video "<videoName>" that is located in the category "<category>"
    And The video starts playing
    When The video has finished playing
    And I rewind the video
    Then The video starts playing

    Examples:
      | region   | location      | profile   | category                | videoName                              |
      | Americas | United States | Architect | FIRESTONE METAL ROOFING | Firestone UC-7 Metal Roofing Animation |