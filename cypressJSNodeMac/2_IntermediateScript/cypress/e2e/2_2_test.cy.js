require('cypress-xpath');

describe('testApp' , () =>{

    beforeEach(() => {
        cy.visit('https://parabank.parasoft.com/parabank/index.htm');
    })

    it ('frontend can be opened -minimal check' , ()=>{
       
        cy.contains('www.parasoft.com')
        
    }
    )

    it ('Login form pass' , ()=>{
       
        cy.contains('Username')
        cy.xpath('//input[@name="username"]').type('test')
        cy.xpath('//input[@name="password"]').type('test')
        cy.get('input.button').click();
        cy.contains('Log Out')
        cy.get('#leftPanel').find('a href="openaccount.htm"')
        
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