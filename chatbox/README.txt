Assumptions :
1) There will be a number of registered users at any given point in the system who can login ( placeholder for password but non-functional as it is public chatroom )
2) AJAX calls made every 3 seconds to refresh active users and message.
3) Set BannedWords on home page to activate filter.
4) On User Logout, listener broadcasts the message on the chatroom that a given user has left the chatroom.