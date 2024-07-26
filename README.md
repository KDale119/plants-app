﻿# plants-app

Sprint 1: 
- Login/Logout
- View Plants & details/care

Sprint 2: 
- Chat gpt
- Wishlist

Sprint 3:
 - Quiz
- UI Component


```mermaid
erDiagram
    USER ||--|{ WISHLIST : wishes
    USER ||--|{ PLANT : plants
    USER ||--|{ QUIZ : takes

    USER {
        string userName
        string userEmail
        string userPassword
    }
    PLANT 
    PLANT {
        int plantId
        int apiId
        string plantName
        string plantSunlight
        string plantWatering

    }
    WISHLIST
    WISHLIST {
        int plantId
        string userName
    }
    QUIZ_QUESTION
    QUIZ_QUESTION {
        int questionId
        string question
    }
    QUIZ ||--|{ QUIZ_QUESTION : contains
    QUIZ ||--|{ PLANT : result

    QUIZ {
        int questionIds
        string userName
        int plantId
    }
    COMMENT ||--|{ USER : writes
    COMMENT ||--|{ PLANT : contains
    COMMENT {
        int commentId
        string comment
        string userName
        int plantId
    
    }
```
