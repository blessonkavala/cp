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
                state: 'app.addUser',
                config: {
                    url: '/addUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/user/UserDetail.html',
                            controller: 'ControllerAddUser as vm'
                        }
                    }
                }
            },
            {
                state: 'app.listUser',
                config: {
                    url: '/listUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/user/ListUser.html',
                            controller: 'ControllerListUser as vm'
                        }
                    }
                }
            },
            {
                state: 'app.viewUser',
                config: {
                    url: '/viewUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/user/UserDetail.html',
                            controller: 'ControllerViewUser as vm',
                        }
                    },
                    params: {
                        rid: true
                    },
                    resolve: {
                        userDetails: getUserDetailsResolve
                    }
                }
            },
            {
                state: 'app.editUser',
                config: {
                    url: '/editUser',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/user/UserDetail.html',
                            controller: 'ControllerEditUser as vm',
                        }
                    },
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