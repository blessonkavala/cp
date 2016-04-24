(function () {
    'use strict';
    angular.module('testApp', [

        'app.core',
        'app.widgets',

        /*
         * Feature areas
         */
        'app.dashboard',
        'app.login',
        'app.user',
        'app.organization',
        'app.bankmaintenance',
        'app.customermaintenance',
        'app.accounts',
        'app.fundtransfer',
        'app.middleoffice'
        

    ]);

})();
