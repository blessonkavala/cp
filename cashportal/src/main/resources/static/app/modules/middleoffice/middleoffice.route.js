(function () {
    'use strict';
    angular.module('app.middleoffice').run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'app.listMOPendingRecords',
                config: {
                    url: '/listMOPendingRecords',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/middleoffice/pendingRecords.html',
                        controller: 'ControllerListMOPendingRecords as vm'
                        }
                    },
                    params : {
                         tnxStatCode: "03"
                    },
                    resolve: {
                        pendingMORecordsResponse: pendingMORecordsResolve
                    }
                }
            },
            {
                state: 'app.listMOExistingRecords',
                config: {
                    url: '/listMOExistingRecords',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/middleoffice/ListExistingRecrods.html',
                        controller: 'ControllerListMOExistingRecords as vm'
                        }
                    },
                    params : {
                         tnxStatCode: "04"
                    },
                    resolve: {
                        existingMORecordsResponse: existingMORecordsResolve
                    }
                }
            },
            
         ];
    }
    
    function pendingMORecordsResolve(MiddleOfficeService,$stateParams){
     'ngInject';
     return MiddleOfficeService.getPendingRecords($stateParams.tnxStatCode);    
    }
    
     function existingMORecordsResolve(MiddleOfficeService,$stateParams){
     'ngInject';
     return MiddleOfficeService.getExistingRecords($stateParams.tnxStatCode);    
    }
    
    function getFundTransferDetailsResolve(FundTransferService,$stateParams){
     'ngInject';
     return FundTransferService.getFundTransferDetails($stateParams.rid);    
    }
    
})();