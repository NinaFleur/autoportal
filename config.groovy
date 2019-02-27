grid {
    isUsed = true
    seleniumHub = 'http://192.168.31.244:4444/wd/hub'
}


//cross browser testing
cbt {
    isUsed = false
}

users {
    user.login = 'Behat'
    password = '123456'
}

environments {
    production {
        url = 'https://autoportal.com/'
    }

    dev {
        url = 'https://dev.autoportal.com/'
        basic.login = 'dev.autoportal.com'
        basic.password = 'nick@dev'
    }
}