(function () {
    'use strict';
    angular.module('app.core').controller('MenuController', MenuController);
    /*ng-inject*/
    function MenuController(userMenu) {

        var vm = this;
        vm.userMenu = userMenu;
    }
})();