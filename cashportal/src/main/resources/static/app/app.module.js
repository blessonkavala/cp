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
        'app.organization'

    ]);

})();
