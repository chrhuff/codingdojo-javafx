import de.cofinpro.codingdojo.service.MinesweeperService;
import de.cofinpro.codingdojo.service.impl.MinesweeperServiceImpl;

module service {
    requires model;

    exports de.cofinpro.codingdojo.service;
    exports de.cofinpro.codingdojo.service.impl to weld.core.impl;

    provides MinesweeperService with MinesweeperServiceImpl;

}