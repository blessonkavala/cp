(function () {
    'use strict';

    angular
        .module('app.core')
        .run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        var otherwise = '/login';
        routerHelper.configureStates(getStates(), otherwise);
    }

    function getStates() {
        return [
            {
                state: 'app',
                config: {
                    url: "/app",
                    abstract: true,
                    templateUrl: "app/modules/menu/menu.html",
                    controller: 'MenuController as vm',
                    resolve: {
                        userMenu: userMenuResolve
                    }
                }
            }
        ];
    }
    
    function userMenuResolve(MenuService, $stateParams) {
    'ngInject';
    return MenuService.getUserMenu();
    }
})();