class UserContainerFacade {
    constructor(userFetcher, userContainerRenderer) {
        this.userFetcher = userFetcher;

        this.observers = [];
        this.addObserver(userContainerRenderer);
    }

    addObserver(observer) {
        this.observers.push(observer);
    }

    notifyObservers(email) {
        for(const observer of this.observers) {
            observer.userUpdate(email);
        }
    }

    async fetchUserStatus() {
        const email = await this.userFetcher.getUserEmail();

        this.notifyObservers(email);
    }
}
