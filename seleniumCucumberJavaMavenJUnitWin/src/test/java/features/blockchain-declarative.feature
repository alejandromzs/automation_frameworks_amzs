Feature: Validation that a block N is related to the N-1 block using the hash of the N-1 block
   AS A: blockchain administrator
   I WANT TO: validate that block N is well chained to N-1 block using the hash of the N-1 block
   IN ORDER TO:  guarantee the blockchain has not been corrupted


  #TC_3 Using Declarative style to test blocks: from 16 to 20
  @TC_3 @Smoke
  Scenario Outline: Verify Blockchain Hash is correct for the first 5 blocks started from the block number 15
    Given I want to test a blockchain page
    When I open the endpoint "<url>" for block number "15"
    And I save the prev_block and the hash for the next 5 blocks using the same endpoint "<url>"
    Then I verify that each hash for a block is equal to the prev_block of the next block

    @Cert
    Examples:
      | url                                             |  |  |
      | https://api.blockcypher.com/v1/btc/main/blocks/ |  |  |
