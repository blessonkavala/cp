(function () {
    'use strict';
    angular.module('app.user').run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'addUser',
                config: {
                    url: '/addUser',
                    templateUrl: 'app/modules/user/UserDetail.html',
                    controller: 'ControllerAddUser as vm'
                }
            },
            {
                state: 'listUser',
                config: {
                    url: '/listUser',
                    templateUrl: 'app/modules/user/ListUser.html',
                    controller: 'ControllerListUser as vm'
                }
            },
            {
                state: 'viewUser',
                config: {
                    url: '/viewUser',
                    templateUrl: 'app/modules/user/UserDetail.html',
                    controller: 'ControllerViewUser as vm',
                    params: {
                        rid: true
                    },
                    resolve: {
                        userDetails: getUserDetailsResolve
                    }
                }
            },
            {
                state: 'editUser',
                config: {
                    url: '/editUser',
                    templateUrl: 'app/modules/user/UserDetail.html',
                    controller: 'ControllerEditUser as vm',
                    params: {
                        rid: true
                    },
                    resolve: {
                        userDetails: getUserDetailsResolve
                    }
                }
            }
            
        ];
    }
    
    function getUserDetailsResolve(UserService, $stateParams) {
    'ngInject';
    return UserService.getUserDetails($stateParams.rid);
    }
})();