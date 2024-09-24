require('cypress-xpath'); 


describe('testApp' , () =>{

    beforeEach(() => {
        cy.visit('https://parabank.parasoft.com/parabank/index.htm');

        //USE OF APIs
        //cy.request('POST','https://someurl/api/removeDBdata')

        // const bodyuser = {
        //     name: 'test',
        //     surename: 'lastname'
        // }
           //cy.request('POST','https://someulr/api/user',bodyuser);

    })


    it ('Test: frontend can be opened - minimal check' , ()=>{
       
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

    it ('Test: Login form pass' , ()=>{
       
        cy.contains('Username')
        cy.xpath('//input[@name="username"]').type('test')
        cy.xpath('//input[@name="password"]').type('test')
        cy.get('input.button').click();
        cy.contains('Log Out')
        cy.contains('Welcome')
        cy.xpath('//table[@id="accountTable"]/thead/tr/th[1]')
            .should('contain','Account')
            .should('have.css','color','rgb(0, 51, 153)')
        
    }
    )

    it ('Test: Login fail' , ()=>{
        cy.visit('https://parabank.parasoft.com/parabank/index.htm');
        cy.contains('Username')
        cy.xpath('//input[@name="username"]').type('test1')
        cy.xpath('//input[@name="password"]').type('test22312803')
        cy.debug(); //You need to have your Developer Tools open for cy.debug() to hit the breakpoint.
        cy.get('input.button').click()
        cy.get('input[value="Log In"]') 
        cy.customCommandExample('Hello, Cypress!'); 
        cy.log('Hello, Cypress! log should also appear in the console browser');
    }
    )
})