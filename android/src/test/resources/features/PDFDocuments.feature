@Android @PDFFiles
Feature: PDF Files
  The purpose of this feature is to cover all the possible scenarios related to the search pdf files.

  Scenario Outline: 01. Search for the document "<document>" with profile "<profile>" in "<region>" - "<location>" using search document input
    Given I am a user located in "<region>" - "<location>" with profile "<profile>"
    When I search for the document "<document>" using the search document input and open it
    Then The document "<document>" is displayed with the title "<documentTitle>" on each page

    Examples:
      | region   | location      | profile   | document              | documentTitle |
      | Americas | United States | Architect | TIS 901A - ISO 95+ GL | ISO 95+™ GL   |
      | Americas | United States | Architect | TIS 901B - ISOGARD GL | ISOGARD™      |
      | Americas | United States | Architect | TIS 917A - RESISTA    | RESISTA™      |

  Scenario Outline: 02. Search for the document "<document>" with profile "<profile>" in "<region>" - "<location>"
    Given I am a user located in "<region>" - "<location>" with profile "<profile>"
    When I open the document "<document>" that is in the path "<category>" > "<subcategory>" > "<segment>"
    Then The document "<document>" is displayed with the title "<documentTitle>" on each page

    Examples:
      | region   | location      | profile   | category                     | subcategory | segment       | document              | documentTitle |
      | Americas | United States | Architect | Technical Information Sheets | Insulation  | Polyiso Board | TIS 901A - ISO 95+ GL | ISO 95+™ GL   |
      | Americas | United States | Architect | Technical Information Sheets | Insulation  | Polyiso Board | TIS 901B - ISOGARD GL | ISOGARD™      |
      | Americas | United States | Architect | Technical Information Sheets | Insulation  | Polyiso Board | TIS 917A - RESISTA    | RESISTA™      |