class UserContainerRenderer extends RendererInterface {
    constructor(targetElement) {
        super();

        this.targetElement = targetElement;
    }

    /**
     * Gets notified by the UserContainerFacade when user status (email) changes
     */
    userUpdate(email) {
        this.render(email);
    }

    /**
     * @param {String} email the email of the user, empty string if not logged in
     */
    render(email) {
        if(email === '') { 
            this.targetElement.innerHTML = `
                <p>You can login <a href='/user/login'>here</a>!</p>
            `;
        } else {
            this.targetElement.innerHTML = `
                <p>Welcome, ${email}! You can logout <a href='/user/logout'>here</a>!</p>
            `;
        }
    }
}
