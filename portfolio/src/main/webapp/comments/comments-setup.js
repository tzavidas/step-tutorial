// Sets up the classes involved with the comment section
const commentsSetup = () => {
    const commentsList = document.getElementsByClassName('comment-list')[0];

    const commentFetcher = new CommentFetcher();
    const commentRenderer = new CommentRenderer(commentsList);
    const commentFacade = new CommentFacade(commentFetcher, commentRenderer);

    document.commentFacade = commentFacade;
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