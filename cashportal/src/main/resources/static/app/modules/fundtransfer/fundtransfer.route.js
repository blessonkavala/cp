(function () {
    'use strict';
    angular.module('app.fundtransfer').run(appRun);

    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
           {
                state: 'app.initInternalFT',
                config: {
                    url: '/initInternalFT',
                    views: {
                        'mainContent': {
                            templateUrl: 'app/modules/fundtransfer/internal/InternalFundtransferDetails.html',
                            controller: 'ControllerInitInternalFT as vm',
                        }
                    },
                    resolve: {
                        screenFT: screenFTResolve
                    }
                }
            },
            {
                state: 'app.listPendingFTs',
                config: {
                    url: '/listPendingFTs',
                    views: {
                    'mainContent': {
                        templateUrl: 'app/modules/fundtransfer/ListPendingFTs.html',
                        controller: 'ControllerListPendingFTs as vm'
                        }
                    },
                    params : {
                         tnxStatCode: "03"
                    },
                    resolve: {
                        pendingFTs: pendingFTsResolve
                    }
                }
            }
        ];
    }
    
    function screenFTResolve(FundTransferService) {
    'ngInject';
        return FundTransferService.getNewInternalFundtransfer();
    }
    
    function pendingFTsResolve(FundTransferService,$stateParams){
     'ngInject';
     return FundTransferService.getPendingFundTransfers($stateParams.tnxStatCode);    
    }
})();