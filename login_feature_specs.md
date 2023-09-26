## Login Feature Specs

## BDD Specs

### Story: User Requests to Login

### Narrative #1

```
As an online user
I want to be able to log in to my account
So I can see the home screen and logged in
```

#### Scenarios (Acceptance criteria)

```
Given the user has connectivity
When the user requests to log in account
Then the app should log in account remotely
And save the session for the user
Then the app should display the home screen
```

## Use Cases

### Login Account Remote Use Case

#### Data:
- URL
- User Account

#### Primary course (happy path):
1. Execute "Login Account" command with above data.
2. System downloads data from the URL.
3. System validates downloaded data.
4. System creates user account from valid data.
5. System delivers user account and navigates to the home screen.

#### No Connectivity – Error Course (Sad Path):
1. System delivers connectivity error.

#### Invalid Data – Error Course (Sad Path):
1. System delivers invalid data error.

#### Not Found – Error Course (Sad Path):
1. System delivers not found error.

#### Internal Server Error – Error Course (Sad Path):
1. System delivers internal server error.

#### Unexpected – Error Course (Sad Path):
1. System delivers unexpected error.

### Save Session Use Case

#### Data:
- User Account

#### Primary course (happy path):
1. Execute "Save User Account" command with above data.
2. System encodes user account data.
3. System saves user account data.
4. System delivers success message.

#### Save – Error Course (Sad Path):
1. System delivers save error.

## Model Specs

### UserAccount
| Property                  | Type     |
|---------------------------|----------|
| `AccessToken`             | `String` |
| `TokenType`               | `String` |
| `User`                    | `Object` |

##### User
| Property           | Type      |
|--------------------|-----------|
| `Id`               | `Integer` |
| `Name`             | `String`  |
| `Email`            | `String`  |
| `Roles`            | `String`  |
| `Address`          | `String`  |
| `HouseNumber`      | `String`  |
| `PhoneNumber`      | `String`  |
| `City`             | `String`  |
| `CreatedAt`        | `Long`    |
| `UpdatedAt`        | `Long`    |
| `ProfilePhotoPath` | `String`  |
| `ProfilePhotoUrl`  | `String`  |

### Payload contract

```
POST http://foodmarket-api.aryaaditiya.com/api/login

Request Body

{
    "email": "hightech@gmail.com",
    "password": "1234567890"
}

Response Body
- 200 Success

{
    "meta": {
        "code": 200,
        "status": "success",
        "message": "Authenticated"
    },
    "data": {
        "access_token": "156|k2IfSRpZ77yMvXktQRIUZPfzWf34kKRB8sikfmif",
        "token_type": "Bearer",
        "user": {
            "id": 8,
            "name": "Fiqri kece",
            "email": "hightech@gmail.com",
            "email_verified_at": null,
            "roles": "USER",
            "current_team_id": null,
            "address": "Jalan berkah",
            "houseNumber": "1",
            "phoneNumber": "1",
            "city": "Berlin",
            "created_at": 1694413249000,
            "updated_at": 1694413249000,
            "profile_photo_path": null,
            "profile_photo_url": "https://ui-avatars.com/api/?name=Fiqri+kece&color=7F9CF5&background=EBF4FF"
        }
    }
}

- 500 Internal Server Error

{
    "meta": {
        "code": 500,
        "status": "error",
        "message": "Authentication Failed"
    },
    "data": {
        "message": "Unauthorized"
    }
}

```

### Flowchart Diagram
<img src="https://github.com/deanuharatinu/GoFood-Clone/assets/24354414/b4ab8c2b-ba6b-4cde-9067-eb731d65b206" width="500" height="700">
