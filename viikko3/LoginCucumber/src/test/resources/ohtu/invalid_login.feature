Feature: User can not log in with invalid username/password-combination

Scenario: user can not login with incorrect password
    Given command login is selected
    When  username "pekka" and password "akkep2" are entered
    Then  system will respond with "wrong username or password"

Scenario: nonexistent user can not login to 
    Given command login is selected
    When  username "eero" and password "akkep2" are entered
    Then  system will respond with "wrong username or password"