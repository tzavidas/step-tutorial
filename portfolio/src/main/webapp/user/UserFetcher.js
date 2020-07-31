class UserFetcher {
    constructor(fetch = window.fetch) {
        this.fetch = fetch;
    }

    /**
     * @returns if logged in user's email, empty string otherwise
     */
    async getUserEmail() {
        const url = '/user/data';

        const res = await fetch(url);
        const email = await res.text();

        if(email === 'false') {
            return '';
        } else {
            return email;
        }
    }
}
