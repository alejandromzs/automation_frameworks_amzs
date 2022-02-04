Feature: Validation that a block N is related to the N-1 block using the hash of the N-1 block
   AS A: blockchain administrator
   I WANT TO: validate that block N is well chained to N-1 block using the hash of the N-1 block
   IN ORDER TO:  guarantee the blockchain has not been corrupted

  @TC_1 @Smoke
  Scenario Outline: Verify Blockchain Has is correct for the first 5 block started from the block number 15
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
       And I save the value from the "prev_block" key in session

    @Dev
    Examples:
      | url                                             |  |
      | https://api.blockcypher.com/v1/btc/main/blocks/ |  |

    @Cert
    Examples:
      | url                                             |  |  |
      | https://api.blockcypher.com/v1/btc/main/blocks/ |  |  |


