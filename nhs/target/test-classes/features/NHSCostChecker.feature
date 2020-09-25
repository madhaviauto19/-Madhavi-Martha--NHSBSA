Feature: NHS Costs Checker

  Scenario Outline: To get cost details from NHS based my details in "<browser>" browser
    Given I have opened NHS Costs Checker in "<browser>" and clicked on start button
    When I have selected "<country>" I live in
    And click next
    And I have provided my "<dob>"
    And click next
    And I have answered my partner status as "<isPartner>"
    And click next
    And I have answered tax claim as "<taxClaim>"
    And click next
    And I have answered if I am pregnant as "<isPregnant>"
    And click next
    And I have selected "<illnessInArmedForces>" about any illness in armed forces
    And click next
    And I have selected "<isDiabetes>" for diabetes
    And click next
    And I have selected "<isGlaucoma>" for glaucoma
    And click next
    And I have selected if myself or my partner live "<inCareHome>"
    And click next
    And If lived in "<inCareHome>" and I have selected "<payFromLocalCouncil>" and based on pay from local cuncil, I have selected "<isSavings>" for "£24,000"
    And If not lived in "<inCareHome>" and I have selected "<isSavings>" for " £16,000"
    Then I get the result whether i will get help from NHS or not

    Examples: 
      | browser | country | dob        | isPartner | taxClaim | isPregnant | illnessInArmedForces | isDiabetes | isGlaucoma | inCareHome | payFromLocalCouncil | isSavings |
      | chrome  | Wales   | 01-01-1985 | Yes       | No       | Yes        | No                   | Yes        | No         | Yes        | Yes                 |           |
      | chrome  | Wales   | 01-01-1985 | Yes       | No       | No         | Yes                  | No         | Yes        | Yes        | No                  | Yes       |
      | chrome  | Wales   | 05-10-1993 | No        | No       | No         | No                   | No         | No         | No         |                     | Yes       |
      | chrome  | Wales   | 05-10-1993 | Yes       | No       | Yes        | Yes                  | Yes        | Yes        | Yes        | Yes                 |           |
      | firefox | Wales   | 01-01-1985 | Yes       | No       | Yes        | No                   | Yes        | No         | Yes        | Yes                 |           |
      | firefox | Wales   | 01-01-1985 | Yes       | No       | No         | Yes                  | No         | Yes        | Yes        | No                  | Yes       |
      | firefox | Wales   | 05-10-1993 | No        | No       | No         | No                   | No         | No         | No         |                     | Yes       |
      | firefox | Wales   | 05-10-1993 | Yes       | No       | Yes        | Yes                  | Yes        | Yes        | Yes        | Yes                 |           |
