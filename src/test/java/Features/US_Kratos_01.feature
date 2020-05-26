Feature: Kratos feature
  This feature aims to test Human and OlympianGod classes and specifically the story of the legendary Kratos
  and the god of war Ares

  Scenario: Kratos defies Ares
    Given a human "Kratos"
    And an olympian god "Ares" known as "the god of war"
    When Kratos defies Ares
    Then Kratos becomes the new god of war
    And kratos becomes immortal
    And Ares loses his title
    And Ares becomes mortal human





