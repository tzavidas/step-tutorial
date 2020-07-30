// Sets up the classes involved with the comment section
const commentsSetup = () => {
    const commentsList = document.getElementsByClassName('comment-list')[0];
    const commentFormContainer = document.getElementsByClassName('comment-post-form-container')[0];

    const commentFetcher = new CommentFetcher();
    const commentRenderer = new CommentRenderer(commentsList);
    const commentFormRenderer = new CommentFormRenderer(commentFormContainer);

    const commentFacade = new CommentFacade(commentFetcher, commentRenderer, commentFormRenderer);
    document.commentFacade = commentFacade;

    document.userContainerFacade.addObserver(commentFacade);
};

const handlePostCommentFormSubmit = (e) => {
    e = e || window.event;
    e.preventDefault();

    const name = document.getElementsByName('comment-name')[0].value;
    const description = document.getElementsByName('comment-description')[0].value;

    document.getElementsByName('comment-name')[0].value = ''; // clear
    document.getElementsByName('comment-description')[0].value = ''; // clear

    document.commentFacade.postComment(name, description);
}
