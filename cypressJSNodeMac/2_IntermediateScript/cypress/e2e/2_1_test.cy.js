require('cypress-xpath');

describe('testApp' , () =>{
    it ('frontend can be opened -minimal check' , ()=>{
        cy.visit('https://parabank.parasoft.com/parabank/index.htm');
        cy.contains('www.parasoft.com')
        
    }
    )

    it ('Register an account' , ()=>{
        cy.visit('https://parabank.parasoft.com/parabank/index.htm');
        cy.xpath('//a[.="Register"]').click();
        cy.get('#customer\\.firstName').type('testFirstName');
        cy.get('#customer\\.lastName').type('testLastName');
        cy.get('#customer\\.address\\.street').type('custAddStreet');
        cy.get('#customer\\.address\\.city').type('custAddcity');
        cy.get('#customer\\.address\\.state').type('custAddState');
        cy.get('#customer\\.address\\.zipCode').type('custAddZipCode');
        cy.get('#customer\\.phoneNumber').type('custPhoneNumber');
        cy.get('#customer\\.ssn').type('custSsn');
        cy.get('#customer\\.username').type('test');
        cy.get('#customer\\.password').type('test');
        cy.get('#repeatedPassword').type('test');
        cy.get('input[value="Register"]').click();
    }
    )

    it ('Login form pass' , ()=>{
        cy.visit('https://parabank.parasoft.com/parabank/index.htm');
        cy.contains('Username')
        cy.xpath('//input[@name="username"]').type('test')
        cy.xpath('//input[@name="password"]').type('test')
        cy.get('input.button').click();
        cy.contains('Log Out')
        
    }
    )

    it ('Login fail' , ()=>{
        cy.visit('https://parabank.parasoft.com/parabank/index.htm');
        cy.contains('Username')
        cy.xpath('//input[@name="username"]').type('test1')
        cy.xpath('//input[@name="password"]').type('test2')
        cy.get('input.button').click()
        cy.get('input[value="Log In"]')
        
    }
    )
})