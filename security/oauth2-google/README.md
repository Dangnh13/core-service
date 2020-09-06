# Google Oauth2 guidelines

## How to get access token by authorization code grant types


#### Step 1: Get authorization code
```sh
    https://accounts.google.com/o/oauth2/auth?client_id=XXX&redirect_uri=YYY&scope=ZZZ&response_type=code
```
#### Step 2: Get access_token and id_token
```sh
$ curl \
--request POST \
--data "code=XXX&client_id=XXX&client_secret=XXX&redirect_uri=XXX&grant_type=authorization_code" \
https://accounts.google.com/o/oauth2/token
```