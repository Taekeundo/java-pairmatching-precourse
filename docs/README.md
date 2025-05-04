# Project Plan & Checklist

## (0) Project Workflow
 1. Setup the project
 2. Execution Flow
 3. Define `Feature List` based on Execution Flow
 4. Implement Features → Build the prototype
 5. Testing → Ensure normal and edge cases work correctly
 6. Refactoring → Improve structure after ensuring stability
 7. Finalization → Polish and clean up, then prepare for submission





## (1) Setup & Project Initialization
- [✅] : Clone repository (forked project)
- [✅] : Make branch with Github name
- [✅] : Verify that project runs properly `./gradlew clean test`
- [✅] : Setup basic folder and package structure
- [✅] : Make the initial commit<br>
        `chore(project): initialize project with basic structure`





## (2) Execution Flow
1. Show main menu
```
기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
```

2. Select an action (User)
```
User input: 1,2,3 or Q
```

3. Handle action based on user input (validate & process)
```
If "1" == 페어 매칭

a. Validate input. (과정, 레벨, 미션)
b. Check if matching data already exists
 - If exists -> Ask user whether to re-match.
 - If "Yes" -> Perform random pair matching and store the result.
 - If "No" -> Go back to step 1 (main menu)
c. If no existing data
 - Perform random pair matching and store the result

```

```
If "2" == 페어 조회

a. Validate input (과정, 레벨, 미션)
b. Load saved pairs and display them
c. If no matching history
 - Display "[ERROR] 매칭 이력이 없습니다."
```

```
If "3" == 페어 초기화

a. Validate input
b. Clear saved pair matching information
C. Display "초기화 되었습니다."

```

```
If "Q" == 종료

a. Exit the program.

```

4. Display results or error messages
```
- Show result
 - If pairs exist already -> Ask if re-matching is needed.
 - If initialized -> Show "초기화 되었습니다."
- Show error messages if input is invalid.
```

5. Repeat or exit
```
- Return to main menu after processing each action
- Continue until user inputs "Q"
- Exit program, when user inputs "Q".
```




## (3) Feature List based on the Execution Flow

### 1. Program Start & Main Menu & User Input
```
[ ] Display the main menu (페어 매칭 , 페어 조회, 페어 초기화, 종료)
[ ] Receive user input (1, 2, 3, or Q)
[ ] Validate menu input (Invalid -> Error)
```

### 2. Pair matching
```
[ ] Display 과정, 레벨, 미션 정보
[ ] Receive 과정, 레벨, 미션 input
[ ] Validate 과정, 레벨, 미션 input
        Invalid → [ERROR] and retry

[ ] Check if matching data already exists for 입력한 과정+레벨+미션
    [ ] If exists, display
        "매칭 정보가 있습니다. 다시 매칭하시겠습니까? (네 | 아니오)"
    [ ] If user selects "아니오", return to main menu
    [ ] If user selects "네", continue to re-match

[ ] Perform random pair matching using Randoms.shuffle

[ ] Validate the matching result
    [ ] If duplicated pair → retry matching (up to 3 times)
    [ ] If failed after 3 tries → Display "[ERROR] 매칭 실패"

[ ] Store the matching result
[ ] Display the matching result to the user
```

### 3. Pair Searching

```
[ ] Display 과정, 레벨, 미션 정보
[ ] Receive 과정, 레벨, 미션 input
[ ] Validate 과정, 레벨, 미션 input
        Invalid → [ERROR] and retry

[ ] Check if matching data exists
    [ ] If exists → Display the saved matching result
    [ ] If not exists → Display "[ERROR] 매칭 이력이 없습니다."
```

### 4. Pair initialization
```
[ ] Validate 초기화 요청
[ ] Clear all saved matching data
[ ] Display "초기화 되었습니다."
```

### 5. Exit
```
[ ] Exit the program
```

### 6. Exception Handling
```
[ ] Validate all user inputs (menu, 과정/레벨/미션)
[ ] If invalid → Display [ERROR] message and retry
```





## (5) Testing
### Goal
- Confirm stability and safety before starting refactoring

### [ Basic Testing ]
- [ ] : Test basic cases. (normal scenarios)
- [ ] : Test edge cases. (e.g., empty, invalid, special conditions)
- [ ] : Test invalid inputs -> ensure proper error handling.
- [ ] : Confirm that no critical errors occur during feature usage.
- [ ] : Create TDD file for core features.

### [ Automated Testing ]
- [ ] : Run `./gradlew clean test`
- [ ] : Perform final test on the website submission page.





## (6) Refactoring Plan

### [ Guidelines ]
- [ ] : Apply SRP
- [ ] : Improve readability
- [ ] : Remove duplicated logic
- [ ] : Clean code (limit depth)
- [ ] : Apply naming conventions (formatting)

### [ Domain ]
- [ ] : Make sure each entity has a clear and simple purpose.

### [ Service ]
- [ ] : Implement business logic (calc, search, etc.).

### [ Controller ]
- [ ] : Handle user input and request flow
- [ ] : Delegate logic to services

### [ View ]
- [ ] : InputView  - Handle user input
- [ ] : OutputView - Display results and errors





## (7) Finalization & Submission

### [ Review ]
- [ ] : Run `./gradlew clean test` <All tests pass>
- [ ] : Verify edge case handling and exceptional cases
- [ ] : Perform final test on the website submission page.
- [ ] : Update README
- [ ] : Create PR for submission