import {Component, OnInit, ViewChild} from '@angular/core';
import {FilterpipePipe} from '../../filterpipe.pipe';
import {ProductsComponent} from '../products/products.component';
import {EcommerceService} from '../services/EcommerceService';
import {Product} from '../models/product.model';
import {faSearch} from '@fortawesome/free-solid-svg-icons';
import {Router} from '@angular/router';

@Component({
    selector: 'app-searchbar',
    templateUrl: './searchbar.component.html',
    styleUrls: ['./searchbar.component.css']
})

export class SearchbarComponent implements OnInit {
    faSearch = faSearch;
    searchText = '';
    products: Product[] = [];
    characters = [
        'Ant-Man',
        'Aquaman',
        'Asterix',
        'The Atom',
        'The Avengers',
        'Batgirl',
        'Batman',
        'Batwoman'
    ];
    enterpressed = false;
    filtered = [];
    @ViewChild('productsC')
    productsC: ProductsComponent;
    listName: [string, number] [] = [];
    constructor(private ecommerceService: EcommerceService, private r: Router) { }

    ngOnInit(): void {
        this.listName = this.loadProductsName();
    }
    loadProductsName() {
        this.ecommerceService.getCategoryUrl(0)
            .subscribe(
                (products: any[]) => {
                    this.products = products;
                    this.products.forEach(product => {
                        this.listName.push([product.name, product.id]);
                    });
                },
                (error) => console.log(error)
            );
        return this.listName;
    }



    search(searchText: string) {
        this.filtered = new FilterpipePipe().transform(this.listName, searchText);
        this.enterpressed = true;
    }

    setSelectedItem($event: MouseEvent, pr: any) {
        // @ts-ignore
        this.r.navigate(['/' + pr]);
    }

}
