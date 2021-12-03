import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {EcommerceComponent} from './ecommerce/ecommerce.component';
import {ProductsComponent} from './ecommerce/products/products.component';
import {ShoppingCartComponent} from './ecommerce/shopping-cart/shopping-cart.component';
import {OrdersComponent} from './ecommerce/orders/orders.component';
import {NgxImageZoomModule} from 'ngx-image-zoom';


import { SocialLoginModule, SocialAuthServiceConfig } from 'angularx-social-login';
import { GoogleLoginProvider } from 'angularx-social-login';

import {EcommerceService} from './ecommerce/services/EcommerceService';
import { LoginComponent } from './ecommerce/login/login.component';
import { SlideshowComponent } from './ecommerce/slideshow/slideshow.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CardsComponent } from './ecommerce/cards/cards.component';
import { FooterComponent } from './ecommerce/footer/footer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { FilterpipePipe } from './filterpipe.pipe';
import { HighlightDirective } from './highlight.directive';
import { SearchbarComponent } from './ecommerce/searchbar/searchbar.component';
import { ProductdescriptionComponent } from './ecommerce/productdescription/productdescription.component';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing/app-routing.module';
import { NavbarComponent } from './ecommerce/navbar/navbar.component';
import { RangebarComponent } from './ecommerce/rangebar/rangebar.component';
import {NgxSliderModule} from '@angular-slider/ngx-slider';

@NgModule({
    declarations: [
        AppComponent,
        EcommerceComponent,
        ProductsComponent,
        ShoppingCartComponent,
        OrdersComponent,
        LoginComponent,
        SlideshowComponent,
        CardsComponent,
        FooterComponent,
        FilterpipePipe,
        HighlightDirective,
        SearchbarComponent,
        ProductdescriptionComponent,
        NavbarComponent,
        RangebarComponent,
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        SocialLoginModule,
        NgbModule,
        FontAwesomeModule,
        RouterModule,
        AppRoutingModule,
        NgxImageZoomModule,
        NgxSliderModule
    ],
    providers: [EcommerceService, {
        provide: 'SocialAuthServiceConfig',
        useValue: {
            autoLogin: false,
            providers: [
                {
                    id: GoogleLoginProvider.PROVIDER_ID,
                    provider: new GoogleLoginProvider(
                        '929294290814-79sh7u5plgta3ec5blj5d2mem32fhu8r.apps.googleusercontent.com'
                    )
                }
            ]
        } as SocialAuthServiceConfig,
    }
    ],
    bootstrap: [AppComponent]
})
export class AppModule {

}
