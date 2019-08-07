import { animate, style, animation, trigger, transition, useAnimation } from '@angular/animations';

export const fadeOut = animation([
  animate('0.6s ease-out', style({ transform: 'translate3d({{ valorTranslado }}, 0, 0)', opacity: 0 }))
])

export const fadeIn = animation([
  style({ transform: 'translate3d({{ valorTranslado }}, 0, 0)', opacity: 0 }),
  animate('0.6s {{ delay }} ease-out',
    style({ transform: 'translate3d(0, 0, 0)', opacity: 1 })
  )
])

export const animacaoPesquisa = [
  trigger("animacaoFormularioPesquisa", [
    transition('void => *', [
      useAnimation(fadeIn, {
        params: {
          valorTranslado: '-100%',
          delay: '0s'
        }
      })
    ]),
    transition('* => void', [
      useAnimation(fadeOut, {
        params: {
          valorTranslado: '-100%'
        }
      })
    ])]
  ),
  trigger("animacaoResultadoPesquisa", [
    transition('void => *', [
      useAnimation(fadeIn, {
        params: {
          valorTranslado: '100%',
          delay: '0s'
        }
      })
    ]),
    transition('* => void', [
      useAnimation(fadeOut, {
        params: {
          valorTranslado: '100%'
        }
      })
    ]),
    transition('col-md-9 => col-md-12', [
      useAnimation(fadeIn, {
        params: {
          valorTranslado: '100%',
          delay: '600ms'
        }
      })
    ]),
    transition('col-md-12 => col-md-9', [
      useAnimation(fadeIn, {
        params: {
          valorTranslado: '100%',
          delay: '0s'
        }
      })
    ])
  ]
  )]





