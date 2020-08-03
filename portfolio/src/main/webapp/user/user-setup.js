const userSetup = () => {
    const userContainer = document.getElementsByClassName('user-status-container')[0];

    const userFetcher = new UserFetcher(fetch);
    const userContainerRenderer = new UserContainerRenderer(userContainer);

    const userContainerFacade = new UserContainerFacade(userFetcher, userContainerRenderer);
    document.userContainerFacade = userContainerFacade;
}
