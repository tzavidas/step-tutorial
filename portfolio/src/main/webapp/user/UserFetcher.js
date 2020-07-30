class UserFetcher {
    constructor(fetch = window.fetch) {
        this.fetch = fetch;
    }

    /**
     * @returns if logged in user's email, otherwise false
     */
    async getUserEmail() {
        const url = '/user/data';

        const res = await fetch(url);
        const data = await res.text();

        if(data === 'false') {
            return null;
        } else {
            return data;
        }

        return email;
    }
}
