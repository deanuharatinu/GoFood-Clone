# GoFood Clone Case Study

This is a learning project for Senior Android Developer Bootcamp from Android Enthusiast Jakarta (AEJ)

## Features
Register Feature Specs [Register](https://github.com/deanuharatinu/GoFood-Clone/blob/development/register_feature_specs.md).
Login Feature Specs [Login](https://github.com/deanuharatinu/GoFood-Clone/blob/development/login_feature_specs.md).

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
