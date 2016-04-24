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
            }
         ];
    }
    
    function pendingMORecordsResolve(MiddleOfficeService,$stateParams){
     'ngInject';
     return MiddleOfficeService.getPendingRecords($stateParams.tnxStatCode);    
    }
    
    function getFundTransferDetailsResolve(FundTransferService,$stateParams){
     'ngInject';
     return FundTransferService.getFundTransferDetails($stateParams.rid);    
    }
    
})();