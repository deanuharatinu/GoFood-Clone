## Register Feature Specs

## BDD Specs

### Story: User Requests to Register

### Narrative #1

```
As an online user
I want to register account
So I can logged in and see the home screen
```

#### Scenarios (Acceptance criteria)

```
Given the user has connectivity
When the user requests to register account
Then the app should register account remotely
And save the session for the user
Then the app should display home screen
```

## Use Cases

### Register Account Remote Use Case

#### Data:
- URL
- User

#### Primary course (happy path):
1. Execute "Register Account" command with above data.
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

### Save User Account Use Case

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

### UserData

| Property                  | Type     |
|---------------------------|----------|
| `Name`                    | `String` |
| `Email`                   | `String` |
| `Password`                | `String` |
| `PasswordConfirmation`    | `String` |
| `Address`                 | `Object` |

##### Address
| Property                  | Type     |
|---------------------------|----------|
| `Address`                 | `String` |
| `City`                    | `String` |
| `HouseNumber`             | `String` |
| `PhoneNumber`             | `String` |


### Payload contract

```
POST http://foodmarket-api.aryaaditiya.com/api/register

Request Body

{
    "name": "Fiqri kece",
    "email": "hightech@gmail.com",
    "password": "1234567890",
    "password_confirmation": "1234567890",
    "address": "Jalan berkah",
    "city": "Berlin",
    "houseNumber": "1",
    "phoneNumber": "1"
}

Response Body

- 200 Success

{
    "meta": {
        "code": 200,
        "status": "success",
        "message": "User Registered"
    },
    "data": {
        "access_token": "194|Gj6FjQQ8W4QcOZuWGC7W6uwXIwPhA1L7HdA488dO",
        "token_type": "Bearer",
        "user": {
            "id": 98,
            "name": "Halo123",
            "email": "halo123@gmail.com",
            "email_verified_at": null,
            "roles": "USER",
            "current_team_id": null,
            "address": "Jalan berkah",
            "houseNumber": "1",
            "phoneNumber": "1",
            "city": "Berlin",
            "created_at": 1695532351000,
            "updated_at": 1695532351000,
            "profile_photo_path": null,
            "profile_photo_url": "https://ui-avatars.com/api/?name=Halo123&color=7F9CF5&background=EBF4FF"
        }
    }
}

```

### Flowchart Diagram
<img src="https://github.com/deanuharatinu/GoFood-Clone/assets/24354414/d5014e93-3e43-4ac0-b6c9-357b76aa7f14" width="500" height="700">

### Architecture Diagram
