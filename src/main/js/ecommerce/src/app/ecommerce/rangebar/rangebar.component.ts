import {Component, OnInit, ViewChild} from '@angular/core';
import { Options, LabelType } from '@angular-slider/ngx-slider';
import {EcommerceService} from '../services/EcommerceService';
import {ProductsComponent} from '../products/products.component';
import {SlideshowComponent} from '../slideshow/slideshow.component';
import {ShoppingCartComponent} from '../shopping-cart/shopping-cart.component';
import {OrdersComponent} from '../orders/orders.component';
import {ProductOrder} from '../models/product-order.model';
import {Product} from '../models/product.model';

@Component({
  selector: 'app-rangebar',
  templateUrl: './rangebar.component.html',
  styleUrls: ['./rangebar.component.css']
})
export class RangebarComponent implements OnInit {
    @ViewChild('productsC')
    productsC: ProductsComponent;

    @ViewChild('slideC')
    slideC: SlideshowComponent;

    @ViewChild('shoppingCartC')
    shoppingCartC: ShoppingCartComponent;

    @ViewChild('ordersC')
    products: Product[] = [];
    ordersC: OrdersComponent;
    value = 0;
    highvalue = 3000;
    options: Options = {
        floor: 0,
        ceil: 3000,
        showSelectionBar: true,
        translate: (value: number, label: LabelType): string => {
            switch (label) {
                case LabelType.Low:
                    return '<b>Min price:</b> $' + value;
                case LabelType.High:
                    return '<b>Max price:</b> $' + value;
                default:
                    return '$' + value;
            }
        },
        getPointerColor: (): string => {
            return '#cc3245';
        }
    };
    loadProductsByRange(i: number, min: number, max: number) {
        this.ecommerceService.productOrders2 = [];
        this.ecommerceService.getProductByRange(min, max, i)
            .subscribe(
                (products: any[]) => {
                    this.products = products;
                    this.products.forEach(product => {
                        this.ecommerceService.productOrders2.push(new ProductOrder(product, 0));
                    });
                },
                (error) => console.log(error)
            );
    }
    sliderEvent() {
        this.loadProductsByRange( this.ecommerceService.category, this.value, this.highvalue);
    }

  constructor(private ecommerceService: EcommerceService) { }

  ngOnInit(): void { }

}
