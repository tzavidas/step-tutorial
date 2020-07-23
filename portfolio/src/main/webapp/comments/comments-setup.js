// Sets up the classes involved with the comment section
const commentsSetup = () => {
    const commentsList = document.getElementsByClassName('comment-list')[0];

    const commentFetcher = new CommentFetcher();
    const commentRenderer = new CommentRenderer(commentsList);
    const commentFacade = new CommentFacade(commentFetcher, commentRenderer);

    document.commentFacade = commentFacade;
};