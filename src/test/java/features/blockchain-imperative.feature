Feature: Validation that a block N is related to the N-1 block using the hash of the N-1 block
   AS A: blockchain administrator
   I WANT TO: validate that block N is well chained to N-1 block using the hash of the N-1 block
   IN ORDER TO:  guarantee the blockchain has not been corrupted


  #TC_1 Using Imperative style to test blocks: from 16 to 20
  @TC_1 @Smoke
  Scenario Outline: Verify Blockchain Hash is correct for the first 5 blocks started from the block number 15
    Given I want to test a blockchain page
    When I open the endpoint "<url>" for block number "15"
      Then I save the value from the "hash" key in session
    When I open the endpoint "<url>" for block number "16"
      Then the current "prev_block" key is equal to the value from session "hash"
       And I save the value from the "hash" key in session
    When I open the endpoint "<url>" for block number "17"
      Then the current "prev_block" key is equal to the value from session "hash"
       And I save the value from the "hash" key in session
    When I open the endpoint "<url>" for block number "18"
       Then the current "prev_block" key is equal to the value from session "hash"
       And I save the value from the "hash" key in session
    When I open the endpoint "<url>" for block number "19"
       Then the current "prev_block" key is equal to the value from session "hash"
       And I save the value from the "hash" key in session
    When I open the endpoint "<url>" for block number "20"
       Then the current "prev_block" key is equal to the value from session "hash"

    @Dev
    Examples:
      | url                                             |  |
      | https://api.blockcypher.com/v1/btc/main/blocks/ |  |

    @Cert
    Examples:
      | url                                             |  |  |
      | https://api.blockcypher.com/v1/btc/main/blocks/ |  |  |


    #Additional example. Using imperative allows to reuse steps to test previous 5 blocks at feature layer
  @TC_2 @Smoke
  Scenario Outline: Verify Blockchain Hash is correct for the previous 5 blocks started from the block number 15
    Given I want to test a blockchain page
    When I open the endpoint "<url>" for block number "15"
    Then I save the value from the "prev_block" key in session
    When I open the endpoint "<url>" for block number "14"
    Then the current "hash" key is equal to the value from session "prev_block"
    And I save the value from the "prev_block" key in session
    When I open the endpoint "<url>" for block number "13"
    Then the current "hash" key is equal to the value from session "prev_block"
    And I save the value from the "prev_block" key in session
    When I open the endpoint "<url>" for block number "12"
    Then the current "hash" key is equal to the value from session "prev_block"
    And I save the value from the "prev_block" key in session
    When I open the endpoint "<url>" for block number "11"
    Then the current "hash" key is equal to the value from session "prev_block"
    And I save the value from the "prev_block" key in session
    When I open the endpoint "<url>" for block number "10"
    Then the current "hash" key is equal to the value from session "prev_block"

    @Cert
    Examples:
      | url                                             |  |
      | https://api.blockcypher.com/v1/btc/main/blocks/ |  |


