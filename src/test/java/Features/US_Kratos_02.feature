Feature: US_kratos_02 Aims to test the case of when a human (not Kratos) defies an olympian god

  Scenario: Only the legendary Kratos can beat the god of war Ares
    Given a human "Deimos" and "Ares" the "god of war"
    And the human is not "Kratos"
    When the human defies Ares
    Then Ares beat him and keep his title
